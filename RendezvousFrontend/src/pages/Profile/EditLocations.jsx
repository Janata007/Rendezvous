import { React, useContext, useEffect } from "react";
import Button from "../../components/Helper/Button";
import Card from "../../components/Helper/Card";
import AppContext from "../../context/app-context";
import RendezvousService from "../../repository/RendezvousRepository";
import "./Profile.css";

const locations = [
  "COFFEE_SHOP",
  "DISCO",
  "BAR",
  "PARK",
  "ICE_SKATING_RINK",
  "BOWLING",
  "MOUNTAIN",
  "ARCADE",
  "MALL",
  "CINEMA",
  "RESTAURANT",
  "CEMETERY",
  "MUSEUM",
  "THEATRE",
  "ESCAPE_ROOM",
  "ZOO",
  "OUTSIDE",
];

const EditLocations = () => {
  const appContext = useContext(AppContext);

  const checkLocationIsPresent = (location) => {
    let userLocations = [];
    appContext.activeUser.locations.forEach((userLocation) => {
      userLocations.push(userLocation.location);
    });

    return userLocations.includes(location);
  };

  const addLocationHandler = (location) => {
    RendezvousService.fetchAllLocations()
      .then((response) => {
        return response.data;
      })
      .then((data) => {
        data.forEach((availableLocation) => {
          if (availableLocation.location === location) {
            RendezvousService.addLocationToUser(
              availableLocation.id,
              appContext.activeUser.id
            )
              .then((response) => {
                if (response.status === 200) {
                  appContext.dispatch({
                    type: "ADD_LOCATION",
                    location: {
                      id: availableLocation.id,
                      location: availableLocation.location,
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
        <h3 className="edit-title">Click to add/remove locations:</h3>

        <ul className="available-list">
          {locations.map((location) => {
            return (
              <li
                key={location}
                className={`available ${
                  checkLocationIsPresent(location) ? "present" : ""
                }`}
                onClick={() => addLocationHandler(location)}
              >
                {location.replace("_", " ")}
              </li>
            );
          })}
        </ul>
      </Card>
      <Button text="Back to Profile" navigateTo="profile" />
    </div>
  );
};

export default EditLocations;
