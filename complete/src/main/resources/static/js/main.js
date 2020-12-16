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

        // trying to make chart
        var ctx = document.getElementById('myChart');
        let beerMap = new Map();
        $http.get('/greeting.json?id=1').then(function(response) {
            beerMap = response.data;
            console.log(Object.keys(beerMap));
            console.log(Object.values(beerMap));
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: Object.keys(beerMap),
                    datasets: [{
                        label: '# of beers',
                        data: Object.values(beerMap),
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                        ],
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
