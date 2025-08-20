using Microsoft.Extensions.Logging;

namespace TDMPW_3P_ExamenFinal;

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
				fonts.AddFont("Happy-Selfie2.ttf", "Happy");
				fonts.AddFont("Rows-of-Sunflowers.ttf", "Sunflowers");
				fonts.AddFont("cream2.ttf", "CreamDemo");
				fonts.AddFont("Aro.ttf", "Aro");
				fonts.AddFont("Valentina.ttf", "Valentina");
			});

#if DEBUG
		builder.Logging.AddDebug();
#endif

		return builder.Build();
	}
}
