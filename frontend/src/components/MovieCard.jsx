import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";

const MovieCard = ({movie}) => {

    //"http://via.placeholder.com/400 - баннер для дефолтной картинки
    return(
        <div className="movie-card">
            <img src={"http://localhost:8080/api/v1/file/download/" + movie.movieId} className="img" alt="http://via.placeholder.com/400"/>
            <div>
                <h3>{movie.name}</h3>
                <h5>{movie.genres[0].name}</h5>
                <h5>Дата релиза: {movie.releaseDate}</h5>
                <h5><span>Описание: </span> {movie.description}</h5>
                <h4><span>Рейтинг MPAA: </span> {movie.mpaa}</h4>
            </div>
        </div>
    )
}

export default MovieCard;