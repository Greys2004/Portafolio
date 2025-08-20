using TDMPW_3P_ExamenFinal.Views;

namespace TDMPW_3P_ExamenFinal;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new Menu();
	}
}
