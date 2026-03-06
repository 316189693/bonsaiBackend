# Bonsai Code Standards

## 1. Source of Truth
- Requirements docs and confirmed design decisions are the source of truth.
- Existing repository patterns are mandatory references.
- No ad-hoc framework or style changes without explicit approval.

## 2. Architecture and Boundaries
- Keep frontend (`bonsaiUI`), backend (`bonsaiBackend`), and infra (`bonsai-infra`) concerns separated.
- Reuse existing modules before introducing new abstractions.
- New directories/files must have a clear purpose tied to a requirement.

## 3. API and Data Contracts
- Do not break existing API contracts without migration notes.
- All contract changes must update corresponding docs and examples.
- Keep naming stable and semantically clear.

## 4. Code Style
- Follow repository formatter/linter settings.
- Prefer small functions with explicit inputs/outputs.
- Avoid magic constants; centralize configuration.
- Keep error handling explicit and actionable.

## 5. Testing and Validation
- Add or update tests for behavior changes.
- Run checks/tests related to changed modules before delivery.
- If tests cannot run, provide reason and manual verification steps.

## 6. Documentation and Knowledge Sync
- After each coding change, update `/root/code/docs/SKILL_KNOWLEDGE_BASE.md` with:
  - what was changed,
  - key decisions/tradeoffs,
  - pitfalls and follow-up notes.
- If behavior or usage changed, update README/spec docs in the affected repo.

## 7. Change Discipline
- Keep diffs minimal and focused.
- Do not mix unrelated refactors with feature or bugfix work.
- Never introduce placeholder logic in production paths without marking and approval.
