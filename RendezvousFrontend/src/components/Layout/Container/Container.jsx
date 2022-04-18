import React, { useContext } from "react";
import AppContext from "../../../context/app-context";
import AuthenticatedApp from "../../Auth/AuthenticatedApp/AuthenticatedApp";
import UnauthenticatedApp from "../../Auth/UnauthenticatedApp/UnauthenticatedApp";
import "./Container.css";

const Container = () => {
  const appContext = useContext(AppContext);

  return (
    <div className="app-container">
      {appContext.isLoggedIn ? <AuthenticatedApp /> : <UnauthenticatedApp />}
    </div>
  );
};

export default Container;
