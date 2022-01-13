$(document).ready( function () {

    $('#add-data-button').on('click', () => {
        fetch('URL')
            .then(res => {
                let data = JSON.parse(res);
                dataTable.clear().draw();
                dataTable.rows.add(res).draw();
            })
            .catch(res => console.log('ERROR ' + res))
        
    })

    let data = [
        [
            "Tiger",
            "Tiger",
        ],
        [
            "Garrett",
            "Garrett",
        ]
    ]

    let dataTable = $('#table_id').DataTable( {
        data: data,
        filter: false,
        ordering: false,
        processing: true,
        retrieve: true  
    });
} );