import React, { useContext } from "react";
import AppContext from "../../../context/app-context";
import "./Container.css";

export const AuthenticatedApp = () => {
  const appContext = useContext(AppContext);
  const logOutHandler = () => {
    appContext.dispatch({
      type: "LOGOFF",
    });
  };
  return (
    <div className="auth app">
      <h1>This is the authenticated app.</h1>
      <button onClick={() => logOutHandler()}>LOGOFF</button>
    </div>
  );
};

export const UnauthenticatedApp = () => {
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

const Container = () => {
  const appContext = useContext(AppContext);

  return (
    <div className="app-container">
      {appContext.isLoggedIn ? <AuthenticatedApp /> : <UnauthenticatedApp />}
    </div>
  );
};

export default Container;
