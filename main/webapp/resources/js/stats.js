/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function generateColor(){
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r}, ${g}, ${b})`
}

function cateChart(id, cateLabels=[], cateInfo=[]) {
    let colors = []
    for(let i = 0; i < cateInfo.length; i++)
        colors.push(generateColor())
    const data = {
        labels: cateLabels,
        datasets: [{
                label: 'Thống kê sản phẩm theo loại',
                data: cateInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'pie',
        data: data,
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}

function proChart(id, proLabels=[], proInfo=[]) {
    let colors = []
    for(let i = 0; i < proInfo.length; i++)
        colors.push(generateColor())
    const data = {
        labels: proLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo sản phẩm',
                data: proInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'line',
        data: data,
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}

function proMonthChart(id, proLabels=[], proInfo=[]) {
    let colors = []
    for(let i = 0; i < proInfo.length; i++)
        colors.push(generateColor())
    const data = {
        labels: proLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo tháng',
                data: proInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'bar',
        data: data,
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}