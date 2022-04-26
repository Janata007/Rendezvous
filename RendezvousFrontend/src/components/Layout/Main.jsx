import { React, useContext, useEffect } from "react";
import AppContext from "../../context/app-context";
import UserCard from "../UserCard";
import "./Main.css";

const Main = () => {
  const appContext = useContext(AppContext);

  useEffect(() => {}, [appContext]);

  return (
    <main className="main">
      <UserCard />
    </main>
  );
};

export default Main;
