/**
 *
 */
const TelesalesApp = angular.module("TelesalesApp", []);

TelesalesApp.filter("checkedItems", function () {
  return function (items, showComplete) {
    let resultArr = [];
    angular.forEach(items, function (item) {
      if ((item.done == false) | (showComplete == true)) {
        resultArr.push(item);
      }
    });
    return resultArr;
  };
});

TelesalesApp.controller("ToDoCtrl", function ($scope) {
  $scope.AccountName = AccountName;
  $scope.incompleteCount = function () {
    let count = 0;
    angular.forEach($scope.todo.items, function (item) {
      if (!item.done) count++;
    });
    return count;
  };

  $scope.warningLevel = function () {
    return $scope.incompleteCount() < 3 ? "bg-success" : "bg-warning";
  };

  $scope.addNewItem = function (actionText) {
    $scope.todo.items.push({ action: actionText, done: false });
  };
});
