import axios from "axios";

const basePath = "http://localhost:8080";

const requests = {

    /**
     * Получить список всех продуктов
     *
     * @return {Promise<axios.AxiosResponse<any> | void>}
     */
    getAllProducts: () => {
        return axios.get(basePath + "/product/all")
            .then(response => {
                return response.data;
            })
            .catch(err => {
                console.log(err)
            });
    },

    /**
     * Удалить продукт по ID
     *
     * @param { Number } id ID продукта
     *
     * @return {Promise<axios.AxiosResponse<any> | void>}
     */
    deleteProduct: (id) => {
        return axios.delete(basePath + `/product/delete/${id}`)
            .then(response => {
                alert(`${response.data.message}`)
                return response.data;
            })
            .catch(err => {
                console.log(err);
            });
    },

    /**
     * Обновить статус продукта
     *
     * @param { Number } id      Id продукта
     * @param { Boolean } status Статус продукта
     *
     * @return {Promise<axios.AxiosResponse<any>>}
     */
    updateProductStatus: (id, status) => {

        const postData = {
            productId: id,
            status: status
        }

        return axios.post(basePath + "/product/update-status", postData)
            .then(response => {
                alert(`${response.data.message}`);
                return response.data;
            })
            .catch(err => {
                console.log(err);
            })
    }
}

export default requests;