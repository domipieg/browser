var app = angular.module('newsbrowser');
app.controller('TechnologyController', function($scope, $http) {
    $http.get('http://localhost:8080/news/pl/technology').
        then(function(response) {
            $scope.technology_news = JSON.stringify(response.data, null, 2);
        });
});