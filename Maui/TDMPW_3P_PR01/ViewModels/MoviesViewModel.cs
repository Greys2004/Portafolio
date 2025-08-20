using System;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using TDMPW_3P_PR01.Models;
using System.Collections.ObjectModel;

namespace TDMPW_3P_PR01.ViewModels;

public partial class MoviesViewModel: ObservableObject
{
    [ObservableProperty]
    private ObservableCollection<Movie> movies = new ObservableCollection<Movie>();

    [ObservableProperty]
    private string newTitle;

    [ObservableProperty]
    private string newDirector;

    [ObservableProperty]
    private DateTime newReleaseDate = DateTime.Now;

    [ObservableProperty]
    private string newGenre;

    //Constructor
    public MoviesViewModel()
    {
    }
    
    // Comando para agregar una película
    [RelayCommand]
    private void AddMovie()
    {
        if (!string.IsNullOrEmpty(NewTitle) && !string.IsNullOrEmpty(NewDirector))
        {
            var movie1 = new Movie
            {
                Title = NewTitle,
                Director = NewDirector,
                ReleaseDate = NewReleaseDate,
                Genre = string.IsNullOrEmpty(NewGenre) ? null : NewGenre
            };

            Movies.Add(movie1);  // Asegúrate de agregar la película correctamente

            // Ordenar las películas cronológicamente por fecha de lanzamiento
            var sortedMovies = Movies.OrderBy(m => m.ReleaseDate).ToList();
            Movies.Clear();
            foreach (var movie in sortedMovies)
            {
                Movies.Add(movie);
            }

            // Limpiar los campos después de agregar la película
            NewTitle = string.Empty;
            NewDirector = string.Empty;
            NewReleaseDate = DateTime.Now;
            NewGenre = string.Empty;
        }
    }

    // Comando para eliminar una película
    [RelayCommand]
    private void DeleteMovie(Movie movie)
    {
        if (movie != null)
        {
            Movies.Remove(movie);
        }
    }
}



