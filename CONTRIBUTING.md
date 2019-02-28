# Follow the workflow as specified:

1. Fork this repository in your account.
2. Clone it on your local machine using `git clone https://github.com/Ashwik/Fest-Manager-App.git`.
3. Add a new remote using `git remote add upstream https://github.com/Ashwik/Fest-Manager-App.git`.
4. Create a new feature branch with `git checkout -b my-branch`.
5. Make your changes.
6. Run your app.
7. Commit your changes.
8. Rebase your commits with `upstream/master`:
  - `git checkout master`
  - `git fetch upstream master`
  - `git reset --hard FETCH_HEAD`
  - `git checkout my-branch`
  - `git rebase master`
9. Resolve any merge conflicts, and then push the branch with `git push origin my-branch`.
10. Create a Pull Request detailing the changes you made and wait for review/merge.