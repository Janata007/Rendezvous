import { React, useContext } from "react";
import AppContext from "../../context/app-context";
import "./Lists.css";

const Locations = () => {
  const appContext = useContext(AppContext);

  return (
    <div className="list-container">
      <h1 className="title">Your Hobbies</h1>

      {appContext.activeUser.locations.length > 0 ? (
        <ul className="list">
          {appContext.activeUser.locations.map((location) => {
            return (
              <li key={location.id} className="badge">
                {location.location}
              </li>
            );
          })}
        </ul>
      ) : (
        <p>You currently have no locations.</p>
      )}
      <span className="edit-link">
        {appContext.activeUser.locations.length > 0 ? "Edit" : "Add"} Locations
      </span>
    </div>
  );
};

export default Locations;
