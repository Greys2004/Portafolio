namespace TDMPW_2P_Examen;

public partial class pagina3 : ContentPage
{
	private const double ComboFamilyPrecio = 290;
	private const double ComboJochosPrecio = 190;
	private const double ComboNachosPrecio = 150;
	private double currentComboPrice = ComboFamilyPrecio;
	public pagina3()
	{
		InitializeComponent();
	}

	private void OnStepperValueChanged(object sender, ValueChangedEventArgs e)
	{
		CantidadLabel.Text = e.NewValue.ToString();
		UpdateTotal();
	}

	private void OnComboFamilyClicked(object sender, EventArgs e)
        {
            ComboImage.Source = "https://tb-static.uber.com/prod/image-proc/processed_images/99d94af3a2cc3e7584a470d8186626d9/5954bcb006b10dbfd0bc160f6370faf3.jpeg"; // URL de la imagen del Combo Family
            ComboTitle.Text = "COMBO FAMILY";
            ComboPrecio.Text = $"${ComboFamilyPrecio}";
            currentComboPrice = ComboFamilyPrecio;
            UpdateTotal();
        }

	private void OnComboJochosClicked(object sender, EventArgs e)
	{
		ComboImage.Source = "https://tb-static.uber.com/prod/image-proc/processed_images/c875ed417a80b3b83b7a075a2ba40f88/7f4ae9ca0446cbc23e71d8d395a98428.jpeg";
		ComboTitle.Text = "COMBO JOCHOS";
		ComboPrecio.Text = $"${ComboJochosPrecio}";
		currentComboPrice = ComboJochosPrecio;
		UpdateTotal();
	}

	private void OnComboNachosClicked(object sender, EventArgs e)
	{
		ComboImage.Source = "https://s3.eu-west-1.amazonaws.com/cdn.spydeals.nl/images/uploads/zTF8Vn8u85mntQAXOoOs94zzOMZkY9D1w65lZOOc.png"; 
		ComboTitle.Text = "COMBO NACHOS";
		ComboPrecio.Text = $"${ComboNachosPrecio}";
		currentComboPrice = ComboNachosPrecio;
		UpdateTotal();
	}

	private void UpdateTotal()
	{
		int cantidad = (int)CantidadStepper.Value;
		double total = currentComboPrice * cantidad;
		TotalLabel.Text = $"Total: ${total}";
	}


}