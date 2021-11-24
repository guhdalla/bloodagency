const ctxG = document.getElementById('chart-genero').getContext('2d');
const chartgenero = new Chart(ctxG,
	{
		type: 'doughnut',
		data: {
			labels: ['Feminino', 'Masculino'],
			datasets: [{
				label: 'Quantidade de pessoas',
				data: yAxisDataGenero,
				backgroundColor: ['rgb(255,91,180)', 'rgb(120,174,255)'],
			}]
		},
		options: {
			responsive: true,
			plugins: {
				legend: {
					position: 'top',
				},
			}
		},
	});