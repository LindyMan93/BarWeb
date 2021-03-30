(function ($) {

    "use strict";
    var app = angular.module('myApp', []);
    app.controller('main', function ($scope, $http) {
        // for menu on left
        var fullHeight = function () {

            $('.js-fullheight').css('height', $(window).height());
            $(window).resize(function () {
                $('.js-fullheight').css('height', $(window).height());
            });

        };
        fullHeight();

        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
        });

        $scope.addBeer = function() {
            let id = document.getElementById('drinkers').value;
            $http.post('/addBeer.json?userId=' + id).then(function(response){
                console.log("Added Beer");
            })
        }

        $scope.addDrinker = function() {
            let fname = document.getElementById('fname').value;
            let lname = document.getElementById('lname').value;
            $http.post("/addDrinker.json?firstName=" + fname + "&lastName=" + lname).then(function(response){
                console.log("Added Drinker");
            });
        };

        function generateRandomRGBColor() {
            var o = Math.round, r = Math.random, s = 255;
            return 'rgba(' + o(r()*s) + ',' + o(r()*s) + ',' + o(r()*s) + ',' + r().toFixed(1) + ')';

        };

        function randomColorList(colorAmount) {
            var colorList = "";
            for(var i = 0; i < colorAmount; i++) {
                if (i==0) {
                    colorList = colorList + "'" + generateRandomRGBColor() + "'";
                } else {
                    colorList = colorList + ", '" + generateRandomRGBColor() + "'";
                }
            }
            return colorList;
        };

        var drinkerSelect = document.getElementById('drinkers');
        let nameMap = new Map();
        $http.get('/getAllDrinkersNamesAndID.json').then(function(response) {
           nameMap = response.data;
           for (const [key, value] of Object.entries(nameMap)) {
               drinkerSelect.options[drinkerSelect.options.length] = new Option(key, value);
           }
        });
        // trying to make chart
        var ctx = document.getElementById('myChart');
        let beerMap = new Map();
        $http.get('/getBeersOfDrinkers.json').then(function(response) {
            beerMap = response.data;
            var backgroundColorList = randomColorList(Object.keys(beerMap).length);
            var borderColorList = randomColorList(Object.keys(beerMap).length);
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: Object.keys(beerMap),
                    datasets: [{
                        label: '# of beers',
                        data: Object.values(beerMap),
                        backgroundColor: [backgroundColorList],
                        borderColor: [borderColorList],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        });

    });

    })(jQuery);
