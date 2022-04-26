import { React, useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import AppContext from "../../context/app-context";
import "./Lists.css";

const Sports = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  useEffect(() => {}, [appContext]);

  return (
    <div className="list-container">
      <h1 className="title">Your Sports</h1>

      {appContext.activeUser.sports.length > 0 ? (
        <ul className="list">
          {appContext.activeUser.sports.map((sport) => {
            return (
              <li key={sport.id} className="badge">
                {sport.sport}
              </li>
            );
          })}
        </ul>
      ) : (
        <p>You currently have no sports.</p>
      )}
      <span className="edit-link" onClick={() => navigate("editSports")}>
        {appContext.activeUser.sports.length > 0 ? "Edit" : "Add"} Sports
      </span>
    </div>
  );
};

export default Sports;
