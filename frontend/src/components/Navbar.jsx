import React from "react";
import {Link} from "react-router-dom";

const Navbar = () => {
    return(
        <nav className="nav">
            <Link to="/" className="site-title">
                <h1>КиноРейтинг</h1>
            </Link>
            <ul>
                <li>
                    <Link to="/movies"><h3><b>Фильмы</b></h3></Link>
                </li>
                <li>
                    <Link to="/genres"><h3><b>Сериалы</b></h3></Link>
                </li>
                <li>
                    <Link to="/genres"><h3><b>Рекомендации</b></h3></Link>
                </li>
                <li>
                    <Link to="/favourites"><h3><b>Избранное</b></h3></Link>
                </li>
                <li>
                    <Link to="/genres"><h3><b>Жанры</b></h3></Link>
                </li>
            </ul>
            <input placeholder="Поск"/>
        </nav>
    )
}

export default Navbar;