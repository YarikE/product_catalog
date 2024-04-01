import React from 'react';
import '../css/global-components.css';

const ToggleButton = ({ isOn, toggle }) => {
    return (
        <button className={isOn ? 'btn-blue' : 'btn-grey'} onClick={toggle} type="button">
            {isOn ? "Включен" : "Выключен"}
        </button>
    );
};

export default ToggleButton;