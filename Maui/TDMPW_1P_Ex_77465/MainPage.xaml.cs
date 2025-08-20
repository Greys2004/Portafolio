namespace TDMPW_1P_Examen;

public partial class MainPage : TabbedPage
{
	int count = 0;

	public MainPage()
	{
		InitializeComponent();
	}

	private void calcularwatts(object sender, EventArgs e)
	{
		double amperes = double.Parse(potenciaAmperios.Text);
    	double voltios = double.Parse(potenciaVoltios.Text);

	 	double potencia = amperes * voltios;

		txtResultadoWatts.Text = $"La potencia en watts es: {potencia:F2}";
	}

	private void calcularPotencia(object sender, EventArgs e)
	{
		double joules = double.Parse(potenciaJoules.Text);
    	double tiempo = double.Parse(potenciaTiempo.Text);

	 	double potencia2 = joules / tiempo;

		txtResultadoPotencia.Text = $"La potencia en watts es: {potencia2:F2}";
	}
}

