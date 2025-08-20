namespace TDMPW_2P_PR02
{
    public partial class hobbie : ContentPage
    {
        public hobbie()
        {
            InitializeComponent();
            miSwitch.IsToggled = true;
            miSlider.IsEnabled = true;
            miStepper.IsVisible = false;
        }

        private void OnSwitchToggled(object sender, ToggledEventArgs e)
        {
            bool isToggled = e.Value;

            if (isToggled)
            {
                // Mostrar solo el slider
                miSlider.IsEnabled = true;
                miStepper.IsVisible = false;
            }
            else
            {
                // Mostrar tanto el slider como el stepper
                miSlider.IsEnabled = false; // El slider será controlado por el stepper
                miStepper.IsVisible = true;
                usarSliderLabel.IsVisible = true;

                // Sincronizar el valor del stepper con el slider
                miStepper.Value = miSlider.Value;
            }
        }

        private void OnSliderValueChanged(object sender, ValueChangedEventArgs e)
        {
            valorActualLabel.Text = $"Valor Actual: {miSlider.Value.ToString("N0")}";
        }

        private void OnStepperValueChanged(object sender, ValueChangedEventArgs e)
        {
            //e.NewValue=== nuevo valor que tiene el stepper
            miSlider.Value = e.NewValue; // Actualizar el valor del slider basado en el stepper
            valorActualLabel.Text = $"Valor Actual: {miSlider.Value.ToString("N0")}";
        }

        private void OnEntryCompleted(object sender, EventArgs e)
        {
            // Obtener el texto del Entry
            var entry = (Entry)sender; //ver propiedades del entry
            string nombre = entry.Text;

            hobbieName.Text = nombre;
            
            // Limpiar el Entry si deseas que se borre después de presionar Enter
            entry.Text = string.Empty; 
        }
    }
}