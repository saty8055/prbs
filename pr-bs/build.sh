echo "================================================================================================================================="

echo "Building UI Assets...."
cd /users/shadow/desktop/sandbox/pr-bs/pr-bs/src/main/pr-bs

ng build

echo "--------------------------------------------------------------------------------------------------------------------------------"

echo "Moving to Back-end library..."

cd dist/pr-bs

mv index.html ./../../../resources/templates/index.html

cd ../..

cp -R ./dist/pr-bs/ ./../resources/static

echo "Cleaning unused files..."

rm -rf dist