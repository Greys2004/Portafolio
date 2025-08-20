namespace TDMPW_2P_Examen;

public partial class pagina2 : ContentPage
    {
        // Propiedades para controlar la visibilidad
        public bool ShowCombos { get; set; }
        public bool ShowMaxiCombos { get; set; }
        public bool ShowCombosLabel { get; set; }
        public bool ShowMaxiCombosLabel { get; set; }

        public pagina2()
        {
            InitializeComponent();
            ShowCombos = true;
            ShowMaxiCombos = true;
            ShowCombosLabel = true;
            ShowMaxiCombosLabel = true;
            BindingContext = this;
        }
        private void OnCombosButtonClicked(object sender, EventArgs e)
        {
            ShowCombos = true;
            ShowMaxiCombos = false;
            ShowCombosLabel = true;
            ShowMaxiCombosLabel = false;
            OnPropertyChanged(nameof(ShowCombos));
            OnPropertyChanged(nameof(ShowMaxiCombos));
            OnPropertyChanged(nameof(ShowCombosLabel));
            OnPropertyChanged(nameof(ShowMaxiCombosLabel));
        }
        private void OnMaxiCombosButtonClicked(object sender, EventArgs e)
        {
            ShowCombos = false;
            ShowMaxiCombos = true;
            ShowCombosLabel = false;
            ShowMaxiCombosLabel = true;
            OnPropertyChanged(nameof(ShowCombos));
            OnPropertyChanged(nameof(ShowMaxiCombos));
            OnPropertyChanged(nameof(ShowCombosLabel));
            OnPropertyChanged(nameof(ShowMaxiCombosLabel));
        }

        private void OnTodosButtonClicked(object sender, EventArgs e)
        {
            ShowCombos = true; // Mostrar todos los combos
            ShowMaxiCombos = true; // Mostrar todos los maxi-combos
            ShowCombosLabel = true; // Asegúrate de que el label de Combos esté visible
            ShowMaxiCombosLabel = true; // Asegúrate de que el label de Maxi Combos esté visible
            OnPropertyChanged(nameof(ShowCombos));
            OnPropertyChanged(nameof(ShowMaxiCombos));
            OnPropertyChanged(nameof(ShowCombosLabel));
            OnPropertyChanged(nameof(ShowMaxiCombosLabel));
        }
    }

