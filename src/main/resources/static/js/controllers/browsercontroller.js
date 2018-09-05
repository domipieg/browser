var app = angular.module('newsbrowser');
app.controller('BrowserController', function($scope, $http) {
$scope.pagination = false;
$scope.countries = ["ae", "ar", "at", "au", "be", "bg", "br", "ca", "ch", "cn", "co", "cu", "cz", "de", "eg", "fr",
                    "gb", "gr", "hk", "hu", "id", "ie", "il", "in", "it", "jp", "kr", "lt", "lv", "ma", "mx", "my",
                    "ng", "nl", "no", "nz", "ph", "pl", "pt", "ro", "rs", "ru", "sa", "se", "sg", "si", "sk", "th",
                    "tr", "tw", "ua", "us", "ve", "za"];
$scope.categories = ["business", "entertainment", "general", "health", "science", "sports", "technology"];

$scope.searchNews = function(selectedCountry, selectedCategory) {
  $http.get('http://localhost:8080/news/' + selectedCountry + '/' + selectedCategory).
          then(function(response) {
              $scope.business_news = response.data;
              $scope.items = $scope.business_news.articles;
              $scope.curPage = 1;
              $scope.itemsPerPage = 3;
              $scope.$watch('curPage + numPerPage', function() {
                  var begin = (($scope.curPage - 1) * $scope.itemsPerPage),
                  end = begin + $scope.itemsPerPage;
                  $scope.numOfPages = Math.ceil($scope.items.length / $scope.itemsPerPage) - 1;
                  $scope.filteredItems = $scope.items.slice(begin, end);
              });
              $scope.pagination = true;
          });
         $scope.externalSite = function(url) {
          window.open("https://" + url, "_blank");
         };
};
});

