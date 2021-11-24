const ctx = document.getElementById('chart-imc').getContext('2d');
		const chartimc = new Chart(ctx,
				{
					type : 'bar',
					data : {
						labels : [ '0 a 10', '11 a 20', '21 a 30', '31 a 40', '41 a 50',
								'51 a 60', '61 a 70' ],
						datasets : [ {
							label : 'Quantidade de pessoas',
							data : yAxisDataIMC,
							backgroundColor : 'rgba(255, 99, 132, 0.2)',
							borderColor : 'rgba(255, 99, 132, 1)',
						} ]
					},
					options : {
						scales : {
							y : {
								beginAtZero : true
							}
						}
					}
				});