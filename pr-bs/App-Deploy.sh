echo "================================================================================================================================="
echo "Checking port : 8064 to make it available for use..."
lsof -i :8064
echo "Clean...."
kill $(lsof -t -i:8064)
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

echo "================================================================================================================================="

echo "Building & Executing API"

cd /users/shadow/desktop/sandbox/pr-bs/pr-bs

mvn spring-boot:run