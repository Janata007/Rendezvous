import { React, useContext, useEffect } from "react";
import Button from "../../components/Helper/Button";
import Card from "../../components/Helper/Card";
import AppContext from "../../context/app-context";
import RendezvousService from "../../repository/RendezvousRepository";
import "./Profile.css";

const musicGenres = [
  "POP",
  "ROCK",
  "INDIE",
  "PUNK",
  "FOLK",
  "GRUNGE",
  "LOFI",
  "JAZZ",
  "CLASSICAL",
  "HOUSE",
  "DUBSTEP",
  "PHONK",
  "TECHNO",
  "HIPHOP",
  "GOSPEL",
  "METAL",
  "OPERA",
  "RNB",
  "REGGAE",
  "HITS",
];

const EditSports = () => {
  const appContext = useContext(AppContext);

  const checkMusicGenreIsPresent = (musicGenre) => {
    let userMusicGenres = [];
    appContext.activeUser.musicGenres.forEach((userMusicGenre) => {
      userMusicGenres.push(userMusicGenre.musicGenre);
    });

    return userMusicGenres.includes(musicGenre);
  };

  const addMusicGenreHandler = (musicGenre) => {
    RendezvousService.fetchAllMusicGenres()
      .then((response) => {
        return response.data;
      })
      .then((data) => {
        data.forEach((availableMusicGenre) => {
          if (availableMusicGenre.musicGenre === musicGenre) {
            RendezvousService.addMusicGenreToUser(
              availableMusicGenre.id,
              appContext.activeUser.id
            )
              .then((response) => {
                if (response.status === 200) {
                  appContext.dispatch({
                    type: "ADD_MUSIC_GENRE",
                    musicGenre: {
                      id: availableMusicGenre.id,
                      musicGenre: availableMusicGenre.musicGenre,
                    },
                  });
                }
              })
              .catch((error) => {
                console.log(error);
              });
          }
        });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {}, [appContext]);

  return (
    <div className="profileEdit page">
      <Card>
        <h3 className="edit-title">Click to add/remove music genres:</h3>

        <ul className="available-list">
          {musicGenres.map((musicGenre) => {
            return (
              <li
                key={musicGenre}
                className={`available ${
                  checkMusicGenreIsPresent(musicGenre) ? "present" : ""
                }`}
                onClick={() => addMusicGenreHandler(musicGenre)}
              >
                {musicGenre}
              </li>
            );
          })}
        </ul>
      </Card>
      <Button text="Back to Profile" navigateTo="profile" />
    </div>
  );
};

export default EditSports;
