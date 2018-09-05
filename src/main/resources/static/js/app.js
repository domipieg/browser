var app = angular.module('newsbrowser', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
      .when('/', {
        templateUrl : 'templates/technology.html',
        controller  : 'TechnologyController'
      })

      .when('/browser', {
        templateUrl : 'templates/browser.html',
        controller  : 'BrowserController'
      })

  .otherwise({redirectTo: '/'});
});