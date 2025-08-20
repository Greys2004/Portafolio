namespace TDMPW_2P_PR02;

public partial class hobbiesVarios : ContentPage
{
	public hobbiesVarios()
	{
		InitializeComponent();
	}

	private void OnSldChange(object sender, EventArgs e)
	{
		// Verificar qué slider disparó el evento
		var slider = (Slider)sender;

		if (slider == barra1)
		{
			txtSid.Text = slider.Value.ToString("N0");
		}
		else if (slider == barra2)
		{
			txtSid2.Text = slider.Value.ToString("N0");
		}
		else if (slider == barra3)
		{
			txtSid3.Text = slider.Value.ToString("N0");
		}
	}

	private void OnEntryCompleted(object sender, EventArgs e)
	{
		// Obtener el texto del Entry
		var entry = (Entry)sender; 
		string nombre = entry.Text;

		hobbieName.Text = nombre;
		
		// Limpiar el Entry si deseas que se borre después de presionar Enter
		entry.Text = string.Empty; 
	}
}