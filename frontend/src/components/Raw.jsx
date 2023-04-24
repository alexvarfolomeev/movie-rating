import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import MovieCard from "./MovieCard";

const Raw = ({ title }) => {
    const GET_MOVIES_URL = "http://localhost:8080/api/v1/movie/get/all";
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        axios
            .get(GET_MOVIES_URL)
            .then(data => {
                setMovies(data.data)
            })
    }, [GET_MOVIES_URL])
    console.log(movies);
    return (
        <>
            <div>
                <h1>{title}</h1>
                <div className="row_container">
                    {movies.map(movie => {
                        return(
                        <Link to={"/movie/" + movie.movieId}>
                            <img src={`http://localhost:8080/api/v1/file/download/${movie.movieId}`} className="row_poster" alt="http://via.placeholder.com/400" />
                        </Link>
                        )
                    })}
                </div>
            </div>
        </>
    )
}

export default Raw;