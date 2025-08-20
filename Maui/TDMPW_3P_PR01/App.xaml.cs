using TDMPW_3P_PR01.Views;

namespace TDMPW_3P_PR01;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new MoviesPage();
	}
}
