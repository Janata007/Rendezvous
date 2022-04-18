import React, { useContext } from "react";
import AppContext from "../../../context/app-context";
import "./UnauthenticatedApp.css";

const UnauthenticatedApp = () => {
  const appContext = useContext(AppContext);
  const logInHandler = () => {
    appContext.dispatch({
      type: "LOGIN",
    });
  };

  return (
    <div className="unauth app">
      <h1>Welcome to Rendezvous, please login to continue</h1>
      <button onClick={() => logInHandler()}>LOGIN</button>
    </div>
  );
};

export default UnauthenticatedApp;
