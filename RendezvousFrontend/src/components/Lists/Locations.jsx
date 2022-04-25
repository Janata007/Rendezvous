import { React, useContext } from "react";
import { useNavigate } from "react-router-dom";
import AppContext from "../../context/app-context";
import "./Lists.css";

const Locations = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  return (
    <div className="list-container">
      <h1 className="title">Your Locations</h1>

      {appContext.activeUser.locations.length > 0 ? (
        <ul className="list">
          {appContext.activeUser.locations.map((location) => {
            return (
              <li key={location.id} className="badge">
                {location.location.replace("_", " ")}
              </li>
            );
          })}
        </ul>
      ) : (
        <p>You currently have no locations.</p>
      )}
      <span className="edit-link" onClick={() => navigate("editLocations")}>
        {appContext.activeUser.locations.length > 0 ? "Edit" : "Add"} Locations
      </span>
    </div>
  );
};

export default Locations;
