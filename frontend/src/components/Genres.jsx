import React from "react";
import { useState, useEffect } from "react";
import axios from 'axios';

const Genres = () => {
    const[genres, setGenres] = useState([]);
    const GET_GENRES_URL = "http://localhost:8080/api/v1/genre/get-all";
    useEffect(() => {
        axios
        .get(GET_GENRES_URL)
        .then(data => {
            setGenres(data.data)
        })
    }, [])
    return(
    <>
        <div className="container">
        <h1>Жанры</h1>
        <div>
            {genres.map(genre => {
                return(
                <ul>
                    <li>{genre.name}</li>
                </ul>
                )
            })}
        </div>
    </div>
    </>
    )
}

export default Genres;