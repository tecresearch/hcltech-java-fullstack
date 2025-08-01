import React, { useState } from "react";
import SearchBox from "./SearchBox";
import InfoBox from "./InfoBox";

export default function WeatherApp() {
    const [weatherInfo, setWeatherInfo] = useState({
        city: "Delhi",
        feelsLike: 24,
        temp: 25,
        tempMin: 23,
        tempMax: 26,
        humidity: 47,
        weather: "Haze",
    });
    const [isModalOpen, setIsModalOpen] = useState(false); // State to control modal visibility

    const updateInfo = (result) => {
        setWeatherInfo(result);
        setIsModalOpen(true); // Open modal when weather info is updated
    };

    const closeModal = () => {
        setIsModalOpen(false); // Close modal
    };

    return (
        <div style={styles.container}>
            <div style={styles.overlay}>
                <h1 style={styles.header}>Weather App</h1>
                <div style={styles.innerContainer}>
                    <SearchBox updateInfo={updateInfo} />
                </div>
            </div>

            {/* Modal */}
            {isModalOpen && (
                <div style={styles.modalOverlay} onClick={closeModal}>
                    <div
                        style={styles.modalContent}
                        onClick={(e) => e.stopPropagation()} // Prevent modal from closing when clicking inside it
                    >
                        <InfoBox info={weatherInfo} />
                        <button onClick={closeModal} style={styles.closeButton}>
                            Close
                        </button>
                    </div>
                </div>
            )}
        </div>
    );
}

const styles = {
    // Whole application background with frosted glass effect
    container: {
        background: 'linear-gradient(180deg, rgba(204, 221, 238, 1) 0%, rgba(169, 186, 202, 0.6) 50%, rgba(116, 126, 138, 0.7) 100%)',
        minHeight: '100vh',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        flexDirection: 'column',
        fontFamily: "'Arial', sans-serif",
        color: '#fff',
        padding: '20px',
        position: 'relative',
        overflow: 'hidden',
        backdropFilter: 'blur(15px)', // Apply blur to the whole background for glassy effect
    },
    // Apply glassy effect to the overlay where the content is centered
    overlay: {
        background: 'rgba(255, 255, 255, 0.2)', // Semi-transparent white background
        backdropFilter: 'blur(10px)',  // Apply blur to create frosted glass effect
        padding: '30px',
        borderRadius: '15px',
        textAlign: 'center',
        maxWidth: '1200px',
        width: '100%',
        border: '2px solid rgba(255, 255, 255, 0.2)', // Light border for the glassy look
    },
    header: {
        fontSize: '3rem',
        fontWeight: 'bold',
        marginBottom: '30px',
        letterSpacing: '2px',
    },
    innerContainer: {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        gap: '30px',
        flexWrap: 'wrap',
        width: '100%',
    },
    // Modal styles
    modalOverlay: {
        position: 'fixed',
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        background: 'rgba(0, 0, 0, 0.7)',  // Dark background overlay
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        zIndex: 1000,  // Ensure modal is above all other content
    },
    modalContent: {
        backgroundColor: 'rgba(255, 255, 255, 0.1)',  // Slightly transparent background for the glassy effect
        backdropFilter: 'blur(10px)', // Apply blur to create frosted glass effect
        padding: '20px',
        borderRadius: '10px',
        width: '400px',
        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.2)',
        textAlign: 'center',
        color: '#fff',
        border: '2px solid rgba(255, 255, 255, 0.3)', // Light border around the modal
    },
    closeButton: {
        marginTop: '20px',
        padding: '10px 20px',
        backgroundColor: '#66ccff',
        color: '#fff',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        fontSize: '1rem',
    },

    // SearchBox styles
    searchBox: {
        backgroundColor: 'rgba(255, 255, 255, 0.2)',  // Glassy effect for search box
        backdropFilter: 'blur(10px)',  // Apply blur to search box
        padding: '10px 20px',
        borderRadius: '10px',
        border: '2px solid rgba(255, 255, 255, 0.3)', // Light border for search box
        width: '300px',
        color: '#fff',
        fontSize: '1rem',
    },

    // InfoBox styles (for the weather info)
    infoBox: {
        backgroundColor: 'rgba(255, 255, 255, 0.2)',  // Glassy effect for info box
        backdropFilter: 'blur(10px)',  // Apply blur to info box
        padding: '20px',
        borderRadius: '10px',
        border: '2px solid rgba(255, 255, 255, 0.3)', // Light border for info box
        color: '#fff',
    },
};
