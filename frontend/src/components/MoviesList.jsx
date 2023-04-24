import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from 'axios';
import MovieCard from "./MovieCard";

const MoviesList = () => {
    const GET_MOVIES_URL = "http://localhost:8080/api/v1/movie/get/all";
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        axios
        .get(GET_MOVIES_URL)
        .then(data => {
            setMovies(data.data)
        })
    }, [])
    return(
        <>
        <h1>Список фильмов</h1>
        <div>
            {movies.map((movie) =>
            <Link to={"/movie/" + movie.movieId}>
                <MovieCard key={movie.movieId} movie={movie}/>
            </Link>
            )}
        </div>
        </>
    )
}

export default MoviesList;