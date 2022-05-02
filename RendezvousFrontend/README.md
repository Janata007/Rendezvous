# Rendezvous React Frontend App

## Authors:

- Jana Markovikj (181112)
- Marko Markovikj (181097)
- Bojan Dabevski (181115)

> This is the frontend client for the Rendezvous app. It is a _**React**_ app that combines state, authentication and rest requests.

## Description:

- ### Layout
  - The app consists of pages rendered as components that combine different smaller ones ( helpers/UI elements etc... ). It follows a page pattern in order to link to different views and simulate a fully fledged web app. A router is being used to enable linking and traversing through the app. The file structure is not perfect but an effort to divide the components into similar groups was done.
- ### Styles
  - For the styles, a decision was made to use plain CSS in order to have full customisability. The typographies, margins and other design characteristics are mostly defined in the [variables file.](./src/styles/variables.css) This allows for an easy redesign if need be.
- ### Logic
  - Actions are placed in the [Rendezvous repository.](./src/repository/RendezvousRepository.jsx) Here you can find all the requests being used and which endpoints they target exactly. We are using a simple custom hook that uses the _**axios**_ library for generating requests.
