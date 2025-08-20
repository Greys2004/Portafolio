using Microsoft.Extensions.Logging;

namespace TDMPW_1P_Examen;

public static class MauiProgram
{
	public static MauiApp CreateMauiApp()
	{
		var builder = MauiApp.CreateBuilder();
		builder
			.UseMauiApp<App>()
			.ConfigureFonts(fonts =>
			{
				fonts.AddFont("OpenSans-Regular.ttf", "OpenSansRegular");
				fonts.AddFont("OpenSans-Semibold.ttf", "OpenSansSemibold");
				fonts.AddFont("Bison.ttf", "Bison");
				fonts.AddFont("Milk.oft", "Milk");
				fonts.AddFont("Panton.ttf", "Panton");
				fonts.AddFont("Roboto.ttf", "Roboto");
			});

#if DEBUG
		builder.Logging.AddDebug();
#endif

		return builder.Build();
	}
}
