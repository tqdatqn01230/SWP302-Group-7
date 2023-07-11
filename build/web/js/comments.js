angular.module("test", [])
    .directive("commentBox", commentBox)
    .controller("baseCont", baseCont);
function baseCont($scope) {
    var activity = [
        { "Name": "Hoang Khang","message":"Ilove it"},
        { "Name": "Hoang Khang","message":"Ilove it"},
        { "Name": "Hoang Khang","message":"Ilove it"},
        { "Name": "Hoang Khang","message":"Ilove it"},
    ];
    $scope.cont = {
        Activity: activity,
    }
}
function commentBox() {
    return {
        scope: {
            item: "=item",
            commentToggle: "=toggle"
        },
        template: ['<div class="JA_AddCommentContainer">','<div class="comment-input" style="margin-left:50px">','<div>','<img src="img/avatar (2).png" width="40" class="rounded-image">','<div style="margin: -40px 0px 10px 60px;">',
        '<input type ="text" class ="form-control">','<div class ="fonts">','<button type ="submit" style="margin-top: 8px;">','<i class ="fa fa-comment">',
        '</i>',' </button>','</div>','</div>','</div>','</div>',
        ].join(''),
        controller: function ($scope) {
            $scope.message = "";
            $scope.save = function () {
                console.log("save this", $scope.item, $scope.message);
            }
            console.log("commentBox", $scope);
        }
    }
}