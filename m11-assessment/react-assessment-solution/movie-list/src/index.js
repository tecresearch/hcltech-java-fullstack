import React from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { applyPolyfills, defineCustomElements } from 'h8k-components/loader';

const container = document.getElementById('root');
const root = createRoot(container);

root.render(
  <React.StrictMode>
    <App initial="120" />
  </React.StrictMode>,
);

registerServiceWorker();

applyPolyfills().then(() => {
  defineCustomElements(window);
});
