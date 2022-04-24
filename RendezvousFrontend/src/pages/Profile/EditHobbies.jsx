import { React, useContext, useEffect } from "react";
import Button from "../../components/Helper/Buttons/Button";
import Card from "../../components/Helper/Card/Card";
import AppContext from "../../context/app-context";
import "./Profile.css";

const hobbies = [
  "READING",
  "EATING_OUT",
  "PAINTING",
  "COOKING",
  "PHOTOGRAPHY",
  "MUSIC",
  "CAMPING",
  "SEWING",
  "GARDENING",
  "VIDEO_GAMES",
  "FISHING",
  "TRAVELING",
  "MOVIES",
  "BOARD_GAMES",
  "PARTYING",
  "WALKS",
  "WRITING",
  "SHOPPING",
];

const EditHobbies = () => {
  const appContext = useContext(AppContext);

  useEffect(() => {}, [appContext.activeUser]);

  return (
    <div className="editHobbies page">
      <Card>
        <h4 className="edit-title">Click to add/remove hobbies:</h4>

        <ul className="available-hobbies">
          {/* {appContext.activeUser.hobbies.forEach((userHobby) => {
            hobbies.map((hobby) => {
              return (
                <li
                  id={hobby}
                  className={`available ${
                    userHobby.hobby === hobby ? "present" : ""
                  }`}
                >
                  {hobby.replace("_", " ")}
                </li>
              );
            });
          })} */}
        </ul>
      </Card>
      <Button text="Back to Profile" navigateTo="profile" />
    </div>
  );
};

export default EditHobbies;
