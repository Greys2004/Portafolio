namespace TDMPW_2P_PR01;

public partial class Personaje1 : ContentPage
{
	public Personaje1()
	{
		InitializeComponent();
	}

	private void OnLikeButtonClicked(object sender, EventArgs e)
	{
		txtResultado.Text = "Me gusta";
	}

	private void OnDislikeButtonClicked(object sender, EventArgs e)
	{
		txtResultado.Text = "No me gusta"; 
	}
}