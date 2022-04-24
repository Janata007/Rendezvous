import { React, useContext } from "react";
import { useNavigate } from "react-router-dom";
import AppContext from "../../context/app-context";
import "./Lists.css";

const MusicGenres = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  return (
    <div className="list-container">
      <h1 className="title">Your Music Genres</h1>

      {appContext.activeUser.musicGenres.length > 0 ? (
        <ul className="list">
          {appContext.activeUser.musicGenres.map((musicGenre) => {
            return (
              <li key={musicGenre.id} className="badge">
                {musicGenre.musicGenre}
              </li>
            );
          })}
        </ul>
      ) : (
        <p>You currently have no music genres.</p>
      )}
      <span className="edit-link" onClick={() => navigate("editMusicGenres")}>
        {appContext.activeUser.musicGenres.length > 0 ? "Edit" : "Add"} Music
        Genres
      </span>
    </div>
  );
};

export default MusicGenres;
