import { React, useContext, useEffect } from "react";
import Button from "../../components/Helper/Button";
import Card from "../../components/Helper/Card";
import AppContext from "../../context/app-context";
import RendezvousService from "../../repository/RendezvousRepository";
import "./Profile.css";

const sports = [
  "RUGBY",
  "FOOTBALL",
  "TENNIS",
  "RUNNING",
  "GYM",
  "HIIT",
  "CROSSFIT",
  "GOLF",
  "VOLLEYBALL",
  "HOCKEY",
  "BASKETBALL",
  "BASEBALL",
  "CHESS",
];

const EditSports = () => {
  const appContext = useContext(AppContext);

  const checkSportIsPresent = (sport) => {
    let userSports = [];
    appContext.activeUser.sports.forEach((userSport) => {
      userSports.push(userSport.sport);
    });

    return userSports.includes(sport);
  };

  const addSportHandler = (sport) => {
    RendezvousService.fetchAllSports()
      .then((response) => {
        return response.data;
      })
      .then((data) => {
        data.forEach((availableSport) => {
          if (availableSport.sport === sport) {
            RendezvousService.addSportToUser(
              availableSport.id,
              appContext.activeUser.id
            )
              .then((response) => {
                if (response.status === 200) {
                  appContext.dispatch({
                    type: "ADD_SPORT",
                    sport: {
                      id: availableSport.id,
                      sport: availableSport.sport,
                    },
                  });

                  console.log("add here");
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

  const removeSportHandler = (sport) => {
    RendezvousService.fetchAllSports()
      .then((response) => {
        return response.data;
      })
      .then((data) => {
        data.forEach((presentSport) => {
          if (presentSport.sport === sport) {
            RendezvousService.removeSportFromUser(
              presentSport.id,
              appContext.activeUser.id
            )
              .then((response) => {
                if (response.status === 200) {
                  appContext.dispatch({
                    type: "REMOVED_SPORT",
                    sport: {
                      id: presentSport.id,
                      sport: presentSport.sport,
                    },
                  });
                }

                console.log("here");
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
        <h3 className="edit-title">Click to add/remove sports:</h3>

        <ul className="available-list">
          {sports.map((sport) => {
            return (
              <li
                key={sport}
                className={`available ${
                  checkSportIsPresent(sport) ? "present" : ""
                }`}
                onClick={() =>
                  checkSportIsPresent(sport)
                    ? removeSportHandler(sport)
                    : addSportHandler(sport)
                }
              >
                {sport}
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
