#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<'EOF'
Usage:
  bash ./build-all.sh

Build all .tex files under ChapterN folders (for all N) using build-latex.sh.
EOF
}

if [[ "${1:-}" == "-h" || "${1:-}" == "--help" ]]; then
  usage
  exit 0
fi

if [[ $# -gt 0 ]]; then
  usage >&2
  exit 1
fi

script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
build_script="$script_dir/build-latex.sh"

if [[ ! -x "$build_script" && ! -f "$build_script" ]]; then
  echo "Missing build script: $build_script" >&2
  exit 1
fi

mapfile -t chapter_dirs < <(
  find "$script_dir" -mindepth 1 -maxdepth 1 -type d -name 'Chapter[0-9]*' | sort -V
)

if [[ ${#chapter_dirs[@]} -eq 0 ]]; then
  echo "No ChapterN folders found."
  exit 0
fi

built_count=0

for chapter_dir in "${chapter_dirs[@]}"; do
  mapfile -t tex_files < <(
    find "$chapter_dir" -mindepth 1 -maxdepth 1 -type f -name '*.tex' | sort -V
  )

  if [[ ${#tex_files[@]} -eq 0 ]]; then
    echo "Skipping $(basename -- "$chapter_dir"): no .tex files found"
    continue
  fi

  for tex_file in "${tex_files[@]}"; do
    echo "Building: ${tex_file#$script_dir/}"
    bash "$build_script" "$tex_file"
    built_count=$((built_count + 1))
  done
done

echo "Built $built_count .tex file(s)."
