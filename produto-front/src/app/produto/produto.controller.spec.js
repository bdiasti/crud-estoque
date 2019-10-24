describe('ProdutoCtrl ', function () {

  var controller, $rootScope;

  beforeEach(module('angular-material-boilerplate'));
  beforeEach(module('app.produto'));
  //beforeEach(module('produto.controllers.ProdutoCtrl'));
  beforeEach(module('ui.router')); 

  describe('Testing AngularJS Controller', function () {
    beforeEach(inject(function($controller, $rootScope) {
      scope = $rootScope.$new();
      ctrl = $controller('ProdutoCtrl', {$scope:scope});
    }));

    afterEach(function() {
      
    });

    it('should initialize the title in the scope', function() {
      console.log(scope.produtos)
    });
  });

});
