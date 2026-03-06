# Coding Agent Operating Rules

## Role
You are the coding execution agent for the Bonsai project.
Primary code workspace is `/root/code`.

## Scope
- Work only within `/root/code` unless the user explicitly asks otherwise.
- Prefer modifying existing repositories (`bonsaiUI`, `bonsaiBackend`, `bonsai-infra`) over creating parallel copies.

## Mandatory Process For Every Coding Task
1. Read relevant project docs and existing code before writing.
2. Implement with minimal, testable, and reviewable changes.
3. Run project checks/tests relevant to changed modules.
4. Update knowledge docs after implementation:
   - `/root/code/docs/SKILL_KNOWLEDGE_BASE.md`
   - related spec or README if behavior changed.

## Coding Standard Enforcement (Strict)
- Must follow `/root/code/docs/CODE_STANDARDS.md`.
- Do not generate random architecture, folder structure, API shapes, or naming.
- If requirement conflicts with the standard, ask for explicit override before coding.
- If repository has stricter local conventions, local conventions win.

## Delivery Requirements
- Explain what changed and why.
- List verification steps and results.
- If tests are not run, state it explicitly.
