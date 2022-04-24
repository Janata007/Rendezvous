import { React, useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import AppContext from "../../context/app-context";
import "./Lists.css";

const Hobbies = () => {
  const appContext = useContext(AppContext);
  let navigate = useNavigate();

  useEffect(() => {}, [appContext]);

  return (
    <div className="list-container">
      <h1 className="title">Your Hobbies</h1>

      {appContext.activeUser.hobbies.length > 0 ? (
        <ul className="list">
          {appContext.activeUser.hobbies.map((hobby) => {
            return (
              <li key={hobby.id} className="badge">
                {hobby.hobby}
              </li>
            );
          })}
        </ul>
      ) : (
        <>
          {" "}
          <p>You currently have no hobbies.</p>
        </>
      )}
      <span className="edit-link" onClick={() => navigate("editHobbies")}>
        {appContext.activeUser.hobbies.length > 0 ? "Edit" : "Add"} Hobbies
      </span>
    </div>
  );
};

export default Hobbies;
