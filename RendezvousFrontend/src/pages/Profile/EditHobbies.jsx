import { React, useContext, useEffect } from "react";
import Button from "../../components/helper/Button";
import Card from "../../components/helper/Card";
import AppContext from "../../context/app-context";
import RendezvousService from "../../repository/RendezvousRepository";
import "./Profile.css";

const hobbies = [
  "READING",
  "EATING_OUT",
  "PAINTING",
  "COOKING",
  "PHOTOGRAPHY",
  "MUSIC",
  "CAMPING",
  "SEWING",
  "GARDENING",
  "VIDEO_GAMES",
  "FISHING",
  "TRAVELING",
  "MOVIES",
  "BOARD_GAMES",
  "PARTYING",
  "WALKS",
  "WRITING",
  "SHOPPING",
];

const EditHobbies = () => {
  const appContext = useContext(AppContext);

  const checkHobbyIsPresent = (hobby) => {
    let userHobbies = [];
    appContext.activeUser.hobbies.forEach((userHobby) => {
      userHobbies.push(userHobby.hobby);
    });

    return userHobbies.includes(hobby);
  };

  const addHobbyHandler = (hobby) => {
    RendezvousService.fetchAllHobbies()
      .then((response) => {
        return response.data;
      })
      .then((data) => {
        data.forEach((availableHobby) => {
          if (availableHobby.hobby === hobby) {
            RendezvousService.addHobbyToUser(
              availableHobby.id,
              appContext.activeUser.id
            )
              .then((response) => {
                if (response.status === 200) {
                  appContext.dispatch({
                    type: "ADD_HOBBY",
                    hobby: {
                      id: availableHobby.id,
                      hobby: availableHobby.hobby,
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

  const removeHobbyHandler = (hobby) => {
    RendezvousService.fetchAllHobbies()
      .then((response) => {
        return response.data;
      })
      .then((data) => {
        data.forEach((presentHobby) => {
          if (presentHobby.hobby === hobby) {
            RendezvousService.removeHobbyFromUser(
              presentHobby.id,
              appContext.activeUser.id
            )
              .then((response) => {
                if (response.status === 200) {
                  appContext.dispatch({
                    type: "REMOVED_HOBBY",
                    hobby: {
                      id: presentHobby.id,
                      hobby: presentHobby.hobby,
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
        <h3 className="edit-title">Click to add/remove hobbies:</h3>

        <ul className="available-list">
          {hobbies.map((hobby) => {
            return (
              <li
                key={hobby}
                className={`available ${
                  checkHobbyIsPresent(hobby) ? "present" : ""
                }`}
                onClick={() =>
                  checkHobbyIsPresent(hobby)
                    ? removeHobbyHandler(hobby)
                    : addHobbyHandler(hobby)
                }
              >
                {hobby.replace("_", " ")}
              </li>
            );
          })}
        </ul>
      </Card>
      <Button text="Back to Profile" navigateTo="profile" />
    </div>
  );
};

export default EditHobbies;
